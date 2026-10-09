import type { Perfil } from "../types/Perfil";
interface PerfilItemProps {
perfil: Perfil;
}
function PerfilItem({ perfil }: PerfilItemProps) {
return (
<li>
<strong>{perfil.nome}</strong> 
</li>
);
}
export default PerfilItem;
