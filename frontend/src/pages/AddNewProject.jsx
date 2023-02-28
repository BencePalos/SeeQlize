import { useState } from "react";
import AddTable from "../components/AddTable";

function AddNewProject() {
  const [tableCount, setTableCount] = useState([1]);
  function addNewTable() {
    setTableCount([...tableCount, 1]);
    console.log(tableCount);
  }
  function handleNewProject(e) {
    e.preventDefault();
  }
  return (
    <form onSubmit={handleNewProject}>
      <input type="text" name="projectName" placeholder="Project name" /> <br />
      {tableCount.map((e, i) => {
        return <AddTable key={i} tableCount={tableCount} />;
      })}
      <button onClick={addNewTable}>Add new Table</button>
      <br />
      <button type="submit">Add project</button>
    </form>
  );
}

export default AddNewProject;
