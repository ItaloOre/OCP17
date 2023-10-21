package com.oracle.ocp.exceptionsLocalization;

public class RuntimeExample {

    public void visitProcupine(){
        try {
            seeAnimal();
        }catch (ExhibitClosedForLunch e){

        }catch (AnimalOutForWalk | ExhibitClosed e){

        }
    }

    private void seeAnimal() {
        throw new AnimalOutForWalk();
    }
}

class AnimalOutForWalk extends RuntimeException{};

class ExhibitClosed extends RuntimeException{};

class ExhibitClosedForLunch extends ExhibitClosed{};