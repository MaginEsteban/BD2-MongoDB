import { Link } from "react-router-dom";

export default function PageSummary({ page }) {
  if (!page) {
      return <p>Page not found</p>; // Muestra un mensaje si page es null o undefined.
  }
  return (
      <header key={page._id}>
        <h1>{page.title}</h1>
        <p>{page.text.substring(0, 53) + "..."}</p>
        <ul className="actions">
          <li>
            <Link to="/page/full" className="button big">
              Leer más...
            </Link>
          </li>
        </ul>
      </header>
    );
}
