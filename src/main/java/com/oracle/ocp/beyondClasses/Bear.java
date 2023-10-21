package com.oracle.ocp.beyondClasses;

public sealed class Bear permits Kodiak, Panda{ //OBLIGADO
}

final class Kodiak extends Bear{

}

non-sealed class Panda extends Bear{

}

//class Totto extends Kodiak, PANDA YA NO PUEDE TENER HIJO

class Totto extends Panda{}



//sealed class MySnake{// MIENTRA ESTA EN EL MISMO ARCHIVO PUEDO OMITIR EL PERMIR
sealed class MySnake permits Cobra,Cobra2,MySnake.Cobra3{ //OJO CON LAS CLASES INTERNAS

    non-sealed class Cobra3 extends MySnake{

    }
}

final class Cobra extends MySnake{}

final class Cobra2 extends MySnake{}