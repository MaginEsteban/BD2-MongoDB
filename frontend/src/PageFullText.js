import { Link } from "react-router-dom";

export default function PageFullText(props) {
   const page = props.page;

       return (
         <section key={page.id}>
           <header className="main">
             <h1>{page.title}</h1>
             <p>{page.text}</p>
           </header>
           <p>By {page.author}</p>
           <ul className="actions">
             <li>
               <Link to="/" className="button big">
                 Pagina principal
               </Link>
             </li>
           </ul>
         </section>
       );
}
