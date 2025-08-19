import { render, screen, fireEvent } from "@testing-library/react";

import { describe, it, expect } from "vitest";

import CounterJSX from "./CounterJSX";

describe("CounterJSX", () => {
    if('Deve rendenizar inicialmente o contador como 0', () => {
        render(<CounterJSX />);

        const countElement = screen.getByTestId('count');

        expect(countElement).toHaveTextContent('0');
    })

    it('Deve incrementar um contador quando o botão for clicado', () => {
        render(<CounterJSX />);

        const countElement = screen.getByTestId('count');
        const buttonElement = screen.getByTestId('Increment')

        fireEvent.click(buttonElement);

        expect(countElement).toHaveTextContent('1');

        fireEvent.click(buttonElement);

        expect(countElement).toHaveTextContent('2');
    })
})