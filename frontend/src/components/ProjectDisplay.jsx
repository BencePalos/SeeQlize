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

  return <div>{props.name}</div>;
}

export default ProjectDisplay;
