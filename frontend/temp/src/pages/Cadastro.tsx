import React from "react";
import { useForm } from "react-hook-form";
import "./Cadastro.css";

interface FormData {
  nomeCompleto: string;
  cpf: string;
  email: string;
  senha: string;
}

const Cadastro: React.FC = () => {
  const { register, handleSubmit } = useForm<FormData>();

  const onSubmit = (data: FormData) => {
    console.log(data);
  };

  return (
    <div className="min-h-screen flex flex-col items-center justify-center bg-lime-100">
      <div className="flex gap-4 absolute top-4">
        <button className="bg-white px-4 py-2 rounded-lg font-bold">IDOSOS</button>
        <button className="bg-white px-4 py-2 rounded-lg font-bold">CADASTROS</button>
      </div>
      <h1 className="text-3xl font-bold mb-6">Página de Cadastro</h1>
      <div className="bg-black text-white p-8 rounded-lg w-96">
        <form onSubmit={handleSubmit(onSubmit)} className="flex flex-col gap-4">
          <label>Nome Completo</label>
          <input {...register("nomeCompleto")} className="p-2 rounded text-black" /> <br />

          <label>CPF</label>
          <input {...register("cpf")} className="p-2 rounded text-black" /> <br />

          <label>E-mail</label>
          <input {...register("email")} type="email" className="p-2 rounded text-black" /> <br />

          <label>Senha</label>
          <input {...register("senha")} type="password" className="p-2 rounded text-black" /> <br />

          <button type="submit" className="bg-white text-black font-bold p-2 rounded mt-4">
            Cadastrar
          </button>
        </form>
      </div>
    </div>
  );
};

export default Cadastro;
export {};
