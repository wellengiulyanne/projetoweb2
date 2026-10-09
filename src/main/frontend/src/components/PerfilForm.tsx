// src/components/PerfilForm.tsx
import { FormEvent, useState } from "react";
import api from "../services/api";
import type { Perfil } from "../types/Perfil";

interface PerfilFormProps {
    onPerfilSalvo: () => void;
    perfilEditando?: Perfil | null;
}

function PerfilForm({ onPerfilSalvo, perfilEditando }: PerfilFormProps) {

    const [nome, setNome] = useState(perfilEditando?.nome ?? "");

    async function handleSubmit(event: FormEvent) {
        event.preventDefault();

        const dados = {
            nome
        };

        if (perfilEditando) {
            await api.put(`/perfil/${perfilEditando.id}`, dados);
        } else {
            await api.post("/perfil", dados);
        }

        onPerfilSalvo();
    }

    return (
        <form onSubmit={handleSubmit}>

            <input
                value={nome}
                onChange={(e) => setNome(e.target.value)}
                placeholder="Nome do perfil"
            />

            <button type="submit">
                {perfilEditando
                    ? "Salvar alterações"
                    : "Cadastrar"}
            </button>

        </form>
    );
}

export default PerfilForm;
