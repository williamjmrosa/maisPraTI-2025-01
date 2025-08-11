import React, { createContext, useContext, useMemo, useState, useCallback } from "react"

const ThemeContext = createContext(null);

export function ThemeProvider({children}){

    const [theme, setTheme] = useState("light")

    const toggleTheme = useCallback(() => setTheme(theme === "light" ? "dark" : "light"), [theme]);

    const value = useMemo(() => ({theme, toggleTheme}), [theme, toggleTheme]);

    return <ThemeContext.Provider value={value}>{children}</ThemeContext.Provider>
}

export function useTheme() {
    const ctx = useContext(ThemeContext);
    if(!ctx) throw new Error("useTheme deve ser usado dentro de um <ThemeProvider");
    return ctx

}