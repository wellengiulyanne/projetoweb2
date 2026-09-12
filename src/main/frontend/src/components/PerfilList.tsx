import { useEffect, useState } from "react";
import api from "../services/api";
import type { Perfil } from "../types/Perfil";
import PerfilItem from "./PerfilItem";
function PerfilList() {
    const [Perfil, setPerfil] = useState<Perfil[]>([]);
    useEffect(() => {
        api.get<Perfil[]>("/perfil").then((resposta) => {
            setPerfil(resposta.data);
        });
    }, []);
    return (
        <ul>
            {Perfil.map((perfil) => (
                <PerfilItem key={perfil.id} perfil={perfil} />
            ))}
        </ul>
    );
}
export default PerfilList;              