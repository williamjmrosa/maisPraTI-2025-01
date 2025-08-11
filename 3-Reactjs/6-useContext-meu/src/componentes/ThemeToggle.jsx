import { useTheme } from "../context/theme.jsx"
function ThemeToggle() {
    
    const {theme, toggleTheme} = useTheme()

    return (
        <button onClick={toggleTheme}>Alterar para {theme === "light" ? "Dark" : "Light"}</button>
    )

}

export default ThemeToggle