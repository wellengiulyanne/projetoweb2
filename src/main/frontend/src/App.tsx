import UsuariosPage from "./pages/UsuarioPage";
import PermissaoPage from "./pages/PermissaoPage";
import PerfilPage from "./pages/PerfilPage";

function App() {
  return (
    <>
      <h1>Cadastro de Usuários</h1>
      <UsuariosPage />

      <h1>Cadastro de Permissões</h1>
      <PermissaoPage />

      <h1>Cadastro de Perfis</h1>
      <PerfilPage />
    </>
  );
}

export default App;