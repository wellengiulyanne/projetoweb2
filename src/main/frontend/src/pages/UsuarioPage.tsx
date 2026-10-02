//src/components/UsuarioList.tsx
import { useEffect, useState } from "react";
import api from "../services/api";
import type { Usuario } from "../types/Usuario";
import UsuarioItem from "../components/UsuarioItem";
import UsuarioForm from "../components/UsuarioForm";

function UsuarioPage() {
    const [usuario, setUsuario] = useState<Usuario[]>([]);
    const [editando, setEditando] = useState<Usuario | null>(null);

    function carregarUsuario() {
        api.get<Usuario[]>("/usuarios").then((resposta) => {
            setUsuario(resposta.data);
        });
    }

    useEffect(() => {
        carregarUsuario();
    }, []);

    async function excluir(id: number) {
        await api.delete(`/usuarios/${id}`);
        carregarUsuario();
    }

    return (
        <div>
            <UsuarioForm
                key={editando?.id ?? "novo"}
                usuarioEditando={editando}
                onUsuarioSalvo={() => {
                    carregarUsuario();
                    setEditando(null);
                }}
            />

            <ul>
                {usuario.map((usuario) => (
                    <li key={usuario.id}>
                        <UsuarioItem usuario={usuario} />
                        <button onClick={() => setEditando(usuario)}>Editar</button>
                        <button onClick={() => excluir(usuario.id)}>Excluir</button>
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default UsuarioPage;
