package listaduplamenteencadeadacliente;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListaDuplamenteEncadeada implements List<Cliente>{
    
    private No primeiro = null;
    
    @Override
    public boolean add(Cliente cliente) {
        No no = new No();
        no.cliente = cliente;
        no.proximo = null;
        no.anterior = null;
        if(isEmpty()){
            primeiro = no;
        }else{
            No aux = primeiro;
            while(aux.proximo != null){
                aux = aux.proximo;
            }
            aux.proximo = no;
            no.anterior = aux;
        }
        return true;
    }
    
    @Override
    public Cliente get(int i) {
        if(isEmpty() && i < 0){
            return null;
        }
        No aux = primeiro;
        int posicaoAtual = 0;
        while(aux != null && posicaoAtual < i){
            aux = aux.proximo;
            posicaoAtual++;
        }
        if(aux == null){
            return null;
        }
        return aux.cliente;
    }

    @Override
    public boolean isEmpty() {
        return primeiro == null;
    }
    
    @Override
    public Cliente remove(int index) {
        if(isEmpty()){
            return null;
        }
        int x = 0;
        No aux = primeiro;
        while(aux != null && index > x){
            aux = aux.proximo;
            x++;
        }
        if(aux == null){
            return null;
        }
        System.out.println(aux.cliente);
        if(aux == primeiro){
            primeiro = aux.proximo;
        }else{
            aux.anterior.proximo = aux.proximo;
        }
        if(aux.proximo != null){
            aux.proximo.anterior = aux.anterior;
        }
        System.out.println(aux.cliente);
        return aux.cliente;
    }
    
    @Override
    public int size() {
        int tamanho = 0;
        No aux = primeiro;
        while(aux != null){
            tamanho++;
            aux = aux.proximo;
        }
        return tamanho;
    }

    private class No {
        Cliente cliente;
        No proximo;
        No anterior;
    }
    
    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<Cliente> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return null;
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> clctn) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Cliente> clctn) {
        return false;
    }

    @Override
    public boolean addAll(int i, Collection<? extends Cliente> clctn) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> clctn) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> clctn) {
        return false;
    }

    @Override
    public void clear() {
        
    }

    @Override
    public Cliente set(int i, Cliente e) {
        return null;
    }

    @Override
    public void add(int i, Cliente e) {
        
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<Cliente> listIterator() {
        return null;
    }

    @Override
    public ListIterator<Cliente> listIterator(int i) {
        return null;
    }

    @Override
    public List<Cliente> subList(int i, int i1) {
        return null;
    }
    
}
