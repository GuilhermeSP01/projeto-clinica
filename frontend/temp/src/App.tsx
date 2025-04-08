import React from "react";
import { Routes, Route } from "react-router-dom";
import Home from "./pages/Home";
import Cadastro from "./pages/Cadastro";
import Login from "./pages/Login";
import FuncInicio from "./pages/FuncInicio";
import UserInicio from "./pages/UserInicio";
import FuncRemedios from "./pages/FuncRemedios";
import UserRemedios from "./pages/UserRemedios";

const App: React.FC = () => {
  return (
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/cadastro" element={<Cadastro />} />
      <Route path="/login" element={<Login />} />
      <Route path="/func" element={<FuncInicio />} />
      <Route path="/user" element={<UserInicio />} />
      <Route path="/func-remedios" element={<FuncRemedios />} />
      <Route path="/user-remedios" element={<UserRemedios />} />
    </Routes>
  );
};

export default App;
