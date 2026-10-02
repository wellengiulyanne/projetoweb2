// src/components/PermissaoList.tsx
import { useEffect, useState } from "react";
import api from "../services/api";
import type { Permissao } from "../types/Permissao";
import PermissaoItem from "../components/PermissaoItem";
import PermissaoForm from "../components/PermissaoForm";

function PermissaoPage() {
    const [permissao, setPermissao] = useState<Permissao[]>([]);
    const [editando, setEditando] = useState<Permissao | null>(null);

    function carregarPermissao() {
        api.get<Permissao[]>("/permissao").then((resposta) => {
            setPermissao(resposta.data);
        });
    }

    useEffect(() => {
        carregarPermissao();
    }, []);

    async function excluir(id: number) {
        await api.delete(`/permissao/${id}`);
        carregarPermissao();
    }

    return (
        <div>
            <PermissaoForm
                key={editando?.id ?? "novo"}
                permissaoEditando={editando}
                onPermissaoSalva={() => {
                    carregarPermissao();
                    setEditando(null);
                }}
            />

            <ul>
                {permissoes.map((permissao) => (
                    <li key={permissao.id}>
                        <PermissaoItem permissao={permissao} />

                        <button onClick={() => setEditando(permissao)}>
                            Editar
                        </button>

                        <button onClick={() => excluir(permissao.id)}>
                            Excluir
                        </button>
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default PermissaoPage;
