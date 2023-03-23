import { useEffect, useState } from "react";
import { useNavigate } from "react-router";
import Select from "react-select";

function ProjectSelector() {
  const [projects, setProjects] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    async function fetchProjects() {
      let projectsData = await fetch("http://127.0.0.1:8080/projects", {
        method: "GET",
        headers: {
          userID: localStorage.getItem("id"),
        },
      });
      let allProjects = await projectsData.json();
      projectsData.ok ? setProjects(allProjects) : alert("No projects found");

      console.log(allProjects);
    }
    fetchProjects();
  }, []);

  const options = [];
  projects.forEach(
    (e, i) => (options[i] = { value: e.project_name, label: e.project_name })
  );

  return projects ? (
    <>
      <div className="projectsDropdown">
        <Select options={options} placeholder="Select a project" />
      </div>
      <button
        onClick={() => {
          navigate("/newProject");
        }}
      >
        Add new project
      </button>
    </>
  ) : (
    "Projects loading"
  );
}

export default ProjectSelector;
