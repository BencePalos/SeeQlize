import { useEffect, useState } from "react";
import Select from "react-select";

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
      setProjects(allProjects);
    }
    fetchProjects();
  }, []);

  const options = [];
  projects.forEach(
    (e, i) => (options[i] = { value: e.project_name, label: e.project_name })
  );

  console.log(options);

  return projects ? (
    <div className="projectsDropdown">
      <Select options={options} />
    </div>
  ) : (
    "Projects loading"
  );
}

export default ProjectSelector;
