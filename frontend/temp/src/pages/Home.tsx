import React from "react";
import { Link } from "react-router-dom"
import "./Home.css";
import Cadastro from "./Cadastro";

const Home: React.FC = () => {
  return (
    <div className="home-container">
      <div className="image-section">
        <img src="/assets/cuidadora.jpg" alt="Cuidadora e idosa" />
      </div>
      <div className="content-section">
        <h1>Ursinhos <span>Carinhosos</span></h1>
        <nav>
          {}
          <Link to="/cadastro">
            <button>Cadastre-se</button>
          </Link>
          <Link to="/login">
            <button>Login</button>
          </Link>
        </nav>
        <footer>
          <span>Desenvolvido por Unip</span>
        </footer>
      </div>
    </div>
  );
};
export default Home;
export {};
