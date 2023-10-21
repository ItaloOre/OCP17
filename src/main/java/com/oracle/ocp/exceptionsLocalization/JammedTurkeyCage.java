package com.oracle.ocp.exceptionsLocalization;

public class JammedTurkeyCage implements AutoCloseable {
    public void close() throws IllegalStateException {
        //ENTRA A UNA LISTA DE EXCPECION SUPRIMIDA Y LUEGO SE CONCATENA EN EL CATCH
        throw new IllegalStateException("Cage door does not close");
    }

    public static void main(String[] args) {
        try (var t = new JammedTurkeyCage()) {
            System.out.println("Put turkeys in");
        } catch (IllegalStateException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}


class JammedTurkeyCage2 implements AutoCloseable {
    public void close() throws IllegalStateException {
        throw new IllegalStateException("Cage door does not close");//SE SUPRIME
    }

    public static void main(String[] args) {
        try (var t = new JammedTurkeyCage()) {
            throw new IllegalStateException("Turkeys ran off");//ESTA sale
            //System.out.println("Put turkeys in");
        } catch (IllegalStateException e) {
            System.out.println("Caught: " + e.getMessage());//ESTA sale
            for(Throwable t : e.getSuppressed()){
                System.out.println("Suppressed: " + t.getMessage());
            }
        }
    }
}

class JammedTurkeyCage3 implements AutoCloseable {

    public static void main(String[] args) {
        try (JammedTurkeyCage t = new JammedTurkeyCage()) {
            throw new RuntimeException("Turkeys ran off");//OJO, AUI LO SUPRIME EL ILEGAL Y LUEGO NADIE LO ATRAPA
        } catch (IllegalStateException e) {
            System.out.println("caught: " + e.getMessage());
        }
    }

    @Override
    public void close() throws IllegalStateException {
        throw new IllegalStateException("Cage door does not close");//SE SUPRIME
    }
}

class JammedTurkeyCage4 implements AutoCloseable {

    public static void main(String[] args) {
        try (JammedTurkeyCage t = new JammedTurkeyCage()) {
            throw new IllegalStateException("Turkeys ran off");
        } finally {
            throw new RuntimeException("and we couldn't find them");//OJO, AUI LO SUPRIME EL ILEGAL Y LUEGO NADIE LO ATRAPA
        }
    }

    @Override
    public void close() throws IllegalStateException {
        throw new IllegalStateException("Cage door does not close");//SE SUPRIME
    }
}
