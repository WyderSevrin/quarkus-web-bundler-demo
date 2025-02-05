import {css, html, LitElement} from 'lit';


/**
 * This component shows the Home screen
 *
 */
class HomeView extends LitElement {
    static styles = css`p {
        color: blue
    }`;


    constructor() {
        super();
    }

    render() {
        return html`
            <p>Home view !</p>
        `;
    }


}

customElements.define('home-view', HomeView);