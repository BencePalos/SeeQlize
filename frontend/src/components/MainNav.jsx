import { useNavigate } from "react-router";
import "../styles/mainNav.css";

function MainNav() {
  const navigate = useNavigate();
  return (
    <div className="mainNav">
      <div className="logo">Q</div>
      <div>
        <ul className="navLinks">
          <li onClick={() => navigate("/")}>Home</li>
          <li onClick={() => navigate("/login")}>Login</li>
          <li onClick={() => navigate("/register")}>Register</li>
          <li>Profile</li>
          <li onClick={() => navigate("/projects")}>Projects</li>
        </ul>
      </div>
    </div>
  );
}

export default MainNav;
