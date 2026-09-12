import UsuarioList from "./components/UsuarioList";
import PermissaoList from "./components/PermissaoList";
import PerfilList from "./components/PerfilList";


function App() {
    return (
        <div>
            <h1>Usuários cadastrados</h1>
            <UsuarioList />

            <h1>Permissões cadastradas</h1>
            <PermissaoList />

            <h1>Perfil</h1>
            <PerfilList /> 
        </div>
    );
}

export default App;