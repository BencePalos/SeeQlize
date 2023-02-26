import { useEffect, useState } from "react";

function ProjectSelector() {
  const [projects, setProjects] = useState([]);
  useEffect(() => {
    async function fetchProjects() {
      let projectsData = await fetch("http://127.0.0.1:8080/projects", {
        method: "GET",
        headers: {
          userID: localStorage.getItem("id"),
        },
      });
      let allProjects = await projectsData.json();
      setProjects([allProjects]);
      console.log(projects);
    }
    fetchProjects();
    setTimeout(() => {
      console.log(projects);
    }, 1000);
  }, []);

  return projects ? (
    <div className="projectsDropdown">
      <select name="projects" defaultValue={"select a project"}>
        <option disabled>Select a project</option>
        {projects.map((e) => {
          return (
            <option key={e.id} value={e.name}>
              {e.name}
            </option>
          );
        })}
      </select>
    </div>
  ) : (
    "Projects loading"
  );
}

export default ProjectSelector;
