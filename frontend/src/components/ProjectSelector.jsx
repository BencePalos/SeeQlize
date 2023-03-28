import { useEffect, useState } from "react";
import { useNavigate } from "react-router";
import Select from "react-select";
import ProjectDisplay from "./ProjectDisplay";

function ProjectSelector() {
  const [projects, setProjects] = useState([]);
  const navigate = useNavigate();
  const [selectedProject, setSelectedProject] = useState(null);

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

  const colourStyles = {
    control: (styles) => ({ ...styles, backgroundColor: "white" }),
    option: (styles, { data, isDisabled, isFocused, isSelected }) => {
      return {
        ...styles,
        backgroundColor: "#6d548f",
        color: "#FFF",
        cursor: isDisabled ? "not-allowed" : "default",
        textAlign: "center",
      };
    },
  };

  const options = [];
  projects.forEach(
    (e, i) =>
      (options[i] = {
        value: e.projectName,
        label: e.projectName,
      })
  );

  function handleProjectSelect(selectedOption) {
    setSelectedProject(selectedOption.value);
  }

  return selectedProject == null ? (
    <>
      <div className="projectsDropdown">
        <Select
          options={options}
          placeholder="Select a project"
          styles={colourStyles}
          onChange={handleProjectSelect}
        />
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
    <>
      <div className="projectsDropdown">
        <Select
          options={options}
          placeholder="Select a project"
          styles={colourStyles}
          onChange={handleProjectSelect}
        />
      </div>
      <button
        onClick={() => {
          navigate("/newProject");
        }}
      >
        Add new project
      </button>
      <ProjectDisplay name={selectedProject} />
    </>
  );
}

export default ProjectSelector;
