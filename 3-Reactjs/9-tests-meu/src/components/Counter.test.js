import { render, screen, fireEvent } from '@testing-library/react';
import { describe, it, expect } from 'vitest';
import Counter from './Counter';

describe('Counter', () => {
    it('Deve incrementar um contador quando o botão for clicado', () => {
        render(<Counter />);

        const countElement = screen.getById('count');
        const buttonElement = screen.getByTestId('increment')

        fireEvent.click(buttonElement);

        expect(countElement).toHaveTextContent('1');
    })
})