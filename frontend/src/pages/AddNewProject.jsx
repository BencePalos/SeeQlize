import { useState } from "react";
import AddTable from "../components/AddTable";
import { projectJSONcreator } from "../functions/projectJSONcreator";

function AddNewProject() {
  const [tableCount, setTableCount] = useState([1]);
  const [projectName, setProjectName] = useState("");

  function addNewTable() {
    setTableCount([...tableCount, 1]);
    console.log(tableCount);
  }

  function handleNewProject(e) {
    e.preventDefault();
    let data = document.querySelectorAll('div[class*="table"]');
    let projectAsJSON = projectJSONcreator(data, projectName);
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
