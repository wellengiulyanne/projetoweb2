// src/components/PerfilList.tsx
import { useEffect, useState } from "react";
import api from "../services/api";
import type { Perfil } from "../types/Perfil";
import PerfilItem from "../components/PerfilItem";
import PerfilForm from "../components/PerfilForm";

function PerfilPage() {
    const [perfil, setPerfil] = useState<Perfil[]>([]);
    const [editando, setEditando] = useState<Perfil | null>(null);

    function carregarPerfil() {
        api.get<Perfil[]>("/perfil").then((resposta) => {
            setPerfil(resposta.data);
        });
    }

    useEffect(() => {
        carregarPerfil();
    }, []);

    async function excluir(id: number) {
        await api.delete(`/perfil/${id}`);
        carregarPerfil();
    }

    return (
        <div>
            <PerfilForm
                key={editando?.id ?? "novo"}
                perfilEditando={editando}
                onPerfilSalvo={() => {
                    carregarPerfil();
                    setEditando(null);
                }}
            />

            <ul>
                {perfil.map((perfil) => (
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

export default PerfilPage;
