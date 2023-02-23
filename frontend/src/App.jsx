import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import "./App.css";
import Home from "./components/Home";
import Register from "./pages/Register";

function App() {
  return (
    <>
      <Router>
        <Routes>
          <Route path={"/"} element={<Home />} />
          <Route path={"/register"} element={<Register />} />
        </Routes>
      </Router>
    </>
  );
}

export default App;
