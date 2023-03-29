import { useEffect, useState } from "react";

function ProjectDisplay(props) {
  const [projectToDisplay, setProjectToDisplay] = useState(null);

  useEffect(() => {
    async function fetchProjectData() {
      let projectData = await fetch(
        `http://127.0.0.1:8080/projects/${props.name}`,
        {
          method: "GET",
          headers: {
            userID: localStorage.getItem("id"),
          },
        }
      );
      let data = await projectData.json();
      setProjectToDisplay(data);
    }
    fetchProjectData();
  }, [props.name]);

  return projectToDisplay ? (
    <>
      <h3>{projectToDisplay.projectName}</h3>
      {projectToDisplay.tables.map((table, index) => {
        return (
          <div>
            <p key={index}>{table.tableName}</p>
            {table.columns.map((column, colIndex) => {
              return (
                <div key={colIndex}>
                  <span>{column.columnName} </span>
                  <span> type: {column.columnType}</span> <br />
                </div>
              );
            })}
          </div>
        );
      })}
    </>
  ) : (
    "Project Loading"
  );
}

export default ProjectDisplay;
