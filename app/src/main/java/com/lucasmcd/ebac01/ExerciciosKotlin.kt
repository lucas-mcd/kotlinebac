package com.lucasmcd.ebac01

import android.util.Log

object ExerciciosKotlin {

    private const val TAG = "ExerciciosKotlin"

    fun executar() {

        // 1. Variável mutável: pode ter seu valor alterado
        var numeroMutavel: Int = 6
        numeroMutavel = 5
        Log.d(TAG, "1. Variável mutável: $numeroMutavel")

        // 2. Variável imutável: não permite reatribuição
        val numeroImutavel: Int = 6
        Log.d(TAG, "2. Variável imutável: $numeroImutavel")

        // numeroImutavel = 7 // Erro: uma variável val não pode ser reatribuída.

        // 3. Verificação com if/else
        val numeroPar = 8
        val numeroImpar = 7

        if (numeroPar % 2 == 0) {
            Log.d(TAG, "3. $numeroPar é par")
        } else {
            Log.d(TAG, "3. $numeroPar é ímpar")
        }

        if (numeroImpar % 2 == 0) {
            Log.d(TAG, "3. $numeroImpar é par")
        } else {
            Log.d(TAG, "3. $numeroImpar é ímpar")
        }

        // 4. Verificação com when
        fun verificarParidade(numero: Int): String {
            return when {
                numero % 2 == 0 -> "$numero é par"
                else -> "$numero é ímpar"
            }
        }

        Log.d(TAG, "4. ${verificarParidade(numeroPar)}")
        Log.d(TAG, "4. ${verificarParidade(numeroImpar)}")

        // 5. Array de inteiros com tamanho 40, preenchido de 1 a 39
        val numerosArray = IntArray(40)

        for (i in 1..39) {
            numerosArray[i] = i
        }

        Log.d(TAG, "5. Array: ${numerosArray.contentToString()}")

        // 6. Lista de inteiros de 1 a 99
        val numerosLista = mutableListOf<Int>()

        for (i in 1..99) {
            numerosLista.add(i)
        }

        Log.d(TAG, "6. Lista: $numerosLista")

        // 7. Soma dos elementos da lista
        var soma = 0

        for (numero in numerosLista) {
            soma += numero
        }

        Log.d(TAG, "7. Soma dos elementos: $soma")
    }
}
