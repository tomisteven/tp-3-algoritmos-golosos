package Logica;

public class AGM {

        private ListaAristas listaAristas;
        private ListaAristas listaNodosAGM;
        private ListaAristas listaAristasAGM;
        private int pesoTotal;

        public AGM() {
            this.listaAristas = new ListaAristas();
            this.listaNodosAGM = new ListaAristas();
            this.listaAristasAGM = new ListaAristas();
            this.pesoTotal = 0;
        }

        public ListaAristas getListaAristas() {
            return listaAristas;
        }

        public void setListaAristas(ListaAristas listaAristas) {
            this.listaAristas = listaAristas;
        }

        public ListaAristas getListaNodosAGM() {
            return listaNodosAGM;
        }

        public void setListaNodosAGM(ListaAristas listaNodosAGM) {
            this.listaNodosAGM = listaNodosAGM;
        }

}
