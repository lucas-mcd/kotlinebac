
package com.lucasmcd.ebac01

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val resultados = StringBuilder()
        var totalTestes = 0
        var testesAprovados = 0

        fun registrarTeste(
            descricao: String,
            resultadoObtido: Any,
            resultadoEsperado: Any
        ) {
            totalTestes++

            val passou = resultadoObtido == resultadoEsperado

            if (passou) {
                testesAprovados++
            }

            resultados.append(
                "${if (passou) "[PASSOU]" else "[FALHOU]"} $descricao\n"
            )
            resultados.append("  Obtido: $resultadoObtido\n")
            resultados.append("  Esperado: $resultadoEsperado\n\n")
        }

        // 1. Variável mutável (var)
        resultados.append("EXERCÍCIO 1 — VARIÁVEL MUTÁVEL\n\n")

        var numeroMutavel: Int = 6
        resultados.append("Valor inicial: $numeroMutavel\n")

        numeroMutavel = 5
        resultados.append("Valor após alteração: $numeroMutavel\n")

        registrarTeste(
            "A variável mutável foi alterada para 5",
            numeroMutavel,
            5
        )

        // 2. Variável imutável (val)
        resultados.append("EXERCÍCIO 2 — VARIÁVEL IMUTÁVEL\n\n")

        val numeroImutavel: Int = 6
        resultados.append("Valor inicial: $numeroImutavel\n")

        // Descomentar a linha abaixo causa erro de compilação:
        // numeroImutavel = 7

        resultados.append(
            "A reatribuição de val é proibida pelo compilador.\n" +
                    "Essa restrição é verificada durante a compilação, " +
                    "não por uma tentativa executada pelo aplicativo.\n\n"
        )

        registrarTeste(
            "A variável imutável mantém o valor inicial",
            numeroImutavel,
            6
        )

        // 3. Condicional if/else
        resultados.append("EXERCÍCIO 3 — IF/ELSE\n\n")

        val numeroPar = 8
        val numeroImpar = 7

        fun verificarParidadeIf(numero: Int): String {
            return if (numero % 2 == 0) {
                "O número é par"
            } else {
                "O número é impar"
            }
        }

        val resultadoParIf = verificarParidadeIf(numeroPar)
        val resultadoImparIf = verificarParidadeIf(numeroImpar)

        resultados.append("$numeroPar: $resultadoParIf\n")
        resultados.append("$numeroImpar: $resultadoImparIf\n\n")

        registrarTeste(
            "if/else identifica um número par",
            resultadoParIf,
            "O número é par"
        )

        registrarTeste(
            "if/else identifica um número ímpar",
            resultadoImparIf,
            "O número é impar"
        )

        // 4. Estrutura when
        resultados.append("EXERCÍCIO 4 — WHEN\n\n")

        fun verificarParidadeWhen(numero: Int): String {
            return when {
                numero % 2 == 0 -> "O número é par"
                else -> "O número é impar"
            }
        }

        val resultadoParWhen = verificarParidadeWhen(numeroPar)
        val resultadoImparWhen = verificarParidadeWhen(numeroImpar)

        resultados.append("$numeroPar: $resultadoParWhen\n")
        resultados.append("$numeroImpar: $resultadoImparWhen\n\n")

        registrarTeste(
            "when identifica um número par",
            resultadoParWhen,
            "O número é par"
        )

        registrarTeste(
            "when identifica um número ímpar",
            resultadoImparWhen,
            "O número é impar"
        )

        // 5. Array de 40 posições
        resultados.append("EXERCÍCIO 5 — ARRAY\n\n")

        val numerosArray = IntArray(40)

        for (i in 1..39) {
            numerosArray[i - 1] = i
        }

        resultados.append("Tamanho: ${numerosArray.size}\n")
        resultados.append("Conteúdo:\n")
        resultados.append(numerosArray.joinToString(", "))
        resultados.append("\n\n")

        registrarTeste(
            "O array possui 40 posições",
            numerosArray.size,
            40
        )

        registrarTeste(
            "As primeiras 39 posições contêm os números de 1 a 39",
            numerosArray.take(39),
            (1..39).toList()
        )

        registrarTeste(
            "A última posição permanece com o valor padrão 0",
            numerosArray[39],
            0
        )

        // 6. Lista de 1 a 99
        resultados.append("EXERCÍCIO 6 — LISTA E FOR\n\n")

        val numerosLista = mutableListOf<Int>()

        for (i in 1..99) {
            numerosLista.add(i)
        }

        resultados.append("Quantidade: ${numerosLista.size}\n")
        resultados.append("Conteúdo:\n")
        resultados.append(numerosLista.joinToString(", "))
        resultados.append("\n\n")

        registrarTeste(
            "A lista possui 99 elementos",
            numerosLista.size,
            99
        )

        registrarTeste(
            "A lista contém os números de 1 a 99 na ordem correta",
            numerosLista,
            (1..99).toList()
        )

        // 7. Soma dos elementos
        resultados.append("EXERCÍCIO 7 — SOMA DA LISTA\n\n")

        var soma: Int = 0

        for (numero in numerosLista) {
            soma += numero
        }

        resultados.append("Soma calculada: $soma\n\n")

        registrarTeste(
            "A soma dos números de 1 a 99 é 4950",
            soma,
            4950
        )

        // Resumo dos testes
        resultados.insert(
            0,
            "TESTES AUTOMÁTICOS DOS EXERCÍCIOS\n\n"
        )

        resultados.append("RESUMO FINAL\n\n")
        resultados.append("Testes aprovados: $testesAprovados\n")
        resultados.append("Total de testes: $totalTestes\n")
        resultados.append(
            if (testesAprovados == totalTestes) {
                "\nTodos os testes executados passaram.\n"
            } else {
                "\nExistem testes que falharam. Confira os resultados acima.\n"
            }
        )

        // Interface Android com rolagem
        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(48, 40, 48, 48)
            setBackgroundColor(Color.rgb(18, 18, 18))
        }

        val titulo = TextView(this).apply {
            text = "Fundamentos de Kotlin"
            textSize = 26f
            setTextColor(Color.rgb(187, 134, 252))
            setTypeface(null, Typeface.BOLD)
            gravity = Gravity.CENTER
            setPadding(0, 0, 0, 12)
        }

        val subtitulo = TextView(this).apply {
            text = "EBAC — Exercícios e testes de validação"
            textSize = 15f
            setTextColor(Color.LTGRAY)
            gravity = Gravity.CENTER
            setPadding(0, 0, 0, 28)
        }

        val textoResultados = TextView(this).apply {
            text = resultados.toString()
            textSize = 14f
            setTextColor(Color.WHITE)
            setLineSpacing(5f, 1f)
            setTextIsSelectable(true)
        }

        layout.addView(
            titulo,
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        )

        layout.addView(
            subtitulo,
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        )

        layout.addView(
            textoResultados,
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        )

        val scrollView = ScrollView(this).apply {
            isFillViewport = true
            addView(layout)
        }

        setContentView(scrollView)
    }
}
