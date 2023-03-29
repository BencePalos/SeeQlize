import { useNavigate } from "react-router";
import "../styles/mainNav.css";

function MainNav() {
  const navigate = useNavigate();

  function hanleLogout(e) {
    e.preventDefault();
    localStorage.removeItem("id");
    navigate("/");
  }

  return localStorage.getItem("id") ? (
    <div className="mainNav">
      <div className="logo">Q</div>
      <div>
        <ul className="navLinks">
          <li onClick={() => navigate("/")}>Home</li>
          <li>Profile</li>
          <li onClick={() => navigate("/projects")}>Projects</li>
          <li
            onClick={(e) => {
              hanleLogout(e);
            }}
          >
            Logout
          </li>
        </ul>
      </div>
    </div>
  ) : (
    <div className="mainNav">
      <div className="logo">Q</div>
      <div>
        <ul className="navLinks">
          <li onClick={() => navigate("/")}>Home</li>
          <li>Profile</li>
          <li onClick={() => navigate("/projects")}>Projects</li>
          <li onClick={() => navigate("/login")}>Login</li>
          <li onClick={() => navigate("/register")}>Register</li>
        </ul>
      </div>
    </div>
  );
}

export default MainNav;
