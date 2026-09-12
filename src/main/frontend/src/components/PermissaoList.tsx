import { useEffect, useState } from "react";
import api from "../services/api";
import type { Permissao } from "../types/Permissao";
import PermissaoItem from "./PermissaoItem";

function PermissaoList() {
    const [permissao, setPermissao] = useState<Permissao[]>([]);
    useEffect(() => {
        api.get<Permissao[]>("/permissao").then((resposta) => {
            setPermissao(resposta.data);
        });
    }, []);
    return (
        <ul>
            {permissao.map((permissao) => (
                <PermissaoItem key={permissao.id} permissao={permissao} />
            ))}
        </ul>
    );
}
export default PermissaoList;