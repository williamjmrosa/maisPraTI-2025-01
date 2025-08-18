import ButtonStyle from "./ButtonModuleExemple.module.css";

export function ButtonModuleExample({children}) {
    return (
        <button className={ButtonStyle.btn}>{children}</button>
    )
}