import { useState } from "react";
import AddTable from "../components/AddTable";
import { projectJSONcreator } from "../functions/projectJSONcreator";

function AddNewProject() {
  const [tableCount, setTableCount] = useState([1]);
  const [projectName, setProjectName] = useState("");
  const userID = localStorage.getItem("id");

  function addNewTable() {
    setTableCount([...tableCount, 1]);
    console.log(tableCount);
  }

  async function handleNewProject(e) {
    e.preventDefault();
    if (!userID) {
      alert("Please log in");
      return;
    }
    console.log(userID);
    let data = document.querySelectorAll('div[class*="table"]');
    let projectAsJSON = projectJSONcreator(data, projectName);
    let response = await fetch("http://127.0.0.1:8080/project", {
      method: "POST",
      headers: {
        "content-type": "application/json",
        id: userID,
      },
      body: JSON.stringify(projectAsJSON),
    });
    let res = await response.json();
  }

  function handleProjectName(e) {
    setProjectName(e.target.value);
  }

  return (
    <form onSubmit={handleNewProject}>
      <input
        type="text"
        name="projectName"
        placeholder="Project name"
        onChange={handleProjectName}
      />
      <br />
      {tableCount.map((e, i) => {
        return <AddTable key={i} tableCount={i + 1} />;
      })}
      <button onClick={addNewTable}>Add new Table</button>
      <br />
      <button type="submit">Add project</button>
    </form>
  );
}

export default AddNewProject;
