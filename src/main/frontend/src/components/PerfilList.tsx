// src/components/PerfilList.tsx
import { useEffect, useState } from "react";
import api from "../services/api";
import type { Perfil } from "../types/Perfil";
import PerfilItem from "./PerfilItem";
import PerfilForm from "./PerfilForm";

function PerfilList() {
  const [perfis, setPerfis] = useState<Perfil[]>([]);
  const [editando, setEditando] = useState<Perfil | null>(null);

  function carregarPerfis() {
    api.get<Perfil[]>("/perfil").then((resposta) => {
      setPerfis(resposta.data);
    });
  }

  useEffect(() => {
    carregarPerfis();
  }, []);

  async function excluir(id: number) {
    await api.delete(`/perfil/${id}`);
    carregarPerfis();
  }

  return (
    <div>
      <PerfilForm
        key={editando?.id ?? "novo"}
        perfilEditando={editando}
        onPerfilSalvo={() => {
          carregarPerfis();
          setEditando(null);
        }}
      />

      <ul>
        {perfis.map((perfil) => (
          <li key={perfil.id}>
            <PerfilItem perfil={perfil} />

            <button onClick={() => setEditando(perfil)}>
              Editar
            </button>

            <button onClick={() => excluir(perfil.id)}>
              Excluir
            </button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default PerfilList;
