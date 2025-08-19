import { render, screen, fireEvent } from "@testing-library/react";

import React from "react";

import { describe, it, expect } from "vitest";

import App from "./App";

describe("App", () => {
    it("Deve incrementar um contador quando o botão for clicado", () => {
        render(<App />)

        const countElement = screen.getByTestId('count');
        const buttonElement = screen.getByText('Incrementar')

        fireEvent.click(buttonElement);

        expect(countElement).toHaveTextContent('1');

        fireEvent.click(buttonElement);

        expect(countElement).toHaveTextContent('2');
    })
})