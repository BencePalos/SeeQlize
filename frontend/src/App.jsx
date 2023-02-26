import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import "./styles/App.css";
import "./styles/mainNav.css";
import Home from "./components/Home";
import Login from "./pages/Login";
import Register from "./pages/Register";
import MainNav from "./components/MainNav";
import Projects from "./pages/Projects";

function App() {
  return (
    <>
      <Router>
        <MainNav />
        <Routes>
          <Route path={"/"} element={<Home />} />
          <Route path={"/register"} element={<Register />} />
          <Route path={"/login"} element={<Login />} />
          <Route path={"/projects"} element={<Projects />} />
        </Routes>
      </Router>
    </>
  );
}

export default App;
