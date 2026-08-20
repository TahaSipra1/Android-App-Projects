package com.example.sipcalcalculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.text.TextAppearanceSpanCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Objects

class MainActivity : AppCompatActivity() {
    lateinit var prilmaryTv: TextView
    lateinit var secondaryTv: TextView
    lateinit var AcBtn: Button
    lateinit var CBtn: Button
    lateinit var brace1Btn: Button
    lateinit var brace2Btn: Button
    lateinit var sinBtn: Button
    lateinit var CosBtn: Button
    lateinit var tanBtn: Button
    lateinit var logBtn: Button
    lateinit var lnBtn: Button
    lateinit var factBtn: Button
    lateinit var squareBtn: Button
    lateinit var squarerootBtn: Button
    lateinit var InvBtn: Button
    lateinit var divisionBtn: Button
    lateinit var MultiplyBtn: Button
    lateinit var AdditionBtn: Button
    lateinit var SubtactinBtn: Button
    lateinit var Btn7: Button
    lateinit var Btn8: Button
    lateinit var Btn9: Button
    lateinit var Btn4: Button
    lateinit var Btn5: Button
    lateinit var Btn6: Button
    lateinit var Btn1: Button
    lateinit var Btn2: Button
    lateinit var Btn3: Button
    lateinit var Btn0: Button
    lateinit var BtnPie: Button
    lateinit var Btnpoint: Button
    lateinit var BtnEqual: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        prilmaryTv=findViewById(R.id.TVPrimary)
        secondaryTv=findViewById(R.id.TVSecondary)
        AcBtn=findViewById(R.id.btnAC)
        CBtn=findViewById(R.id.btnC)
        brace1Btn=findViewById(R.id.btnBrac1)
        brace2Btn=findViewById(R.id.btnBrac2)
        sinBtn=findViewById(R.id.btnSin)
        CosBtn=findViewById(R.id.btnCos)
        tanBtn=findViewById(R.id.btnTan)
        logBtn=findViewById(R.id.BtnLog)
        lnBtn=findViewById(R.id.BtnLn)
        factBtn=findViewById(R.id.btnFact)
        squareBtn=findViewById(R.id.btnSquare)
        squarerootBtn=findViewById(R.id.btnSquareRoot)
        InvBtn=findViewById(R.id.BtnInv)
        divisionBtn=findViewById(R.id.BtnDiv)
        MultiplyBtn=findViewById(R.id.BtnMul)
        SubtactinBtn=findViewById(R.id.BtnSubtract)
        AdditionBtn=findViewById(R.id.Btnsum)
        BtnEqual=findViewById(R.id.BtnEqual)
        BtnPie=findViewById(R.id.btnPie)
        Btnpoint=findViewById(R.id.btnDot)
        Btn7=findViewById(R.id.btn7)
        Btn8=findViewById(R.id.btn8)
        Btn9=findViewById(R.id.btn9)
        Btn4=findViewById(R.id.btn4)
        Btn5=findViewById(R.id.btn5)
        Btn6=findViewById(R.id.btn6)
        Btn1=findViewById(R.id.btn1)
        Btn2=findViewById(R.id.btn2)
        Btn3=findViewById(R.id.btn3)
        Btn0=findViewById(R.id.btn0)

        Btn0.setOnClickListener {
            prilmaryTv.text=(prilmaryTv.text.toString()+"0")

        }
        Btn1.setOnClickListener {
            prilmaryTv.text=(prilmaryTv.text.toString()+"1")
        }
        Btn2.setOnClickListener {
            prilmaryTv.text=(prilmaryTv.text.toString()+"2")
        }
        Btn3.setOnClickListener {
            prilmaryTv.text=(prilmaryTv.text.toString()+"3")

        }
        Btn4.setOnClickListener {
            prilmaryTv.text=(prilmaryTv.text.toString()+"4")

        }
        Btn5.setOnClickListener {
            prilmaryTv.text=(prilmaryTv.text.toString()+"5")

        }
        Btn6.setOnClickListener {
            prilmaryTv.text=(prilmaryTv.text.toString()+"6")

        }
        Btn7.setOnClickListener {
            prilmaryTv.text=(prilmaryTv.text.toString()+"7")

        }
        Btn8.setOnClickListener {
            prilmaryTv.text=(prilmaryTv.text.toString()+"8")

        }
        Btn9.setOnClickListener {
            prilmaryTv.text=(prilmaryTv.text.toString()+"9")

        }
        Btnpoint.setOnClickListener {
            prilmaryTv.text=(prilmaryTv.text.toString()+".")
        }
        AdditionBtn.setOnClickListener {
            prilmaryTv.text=(prilmaryTv.text.toString()+"+")
        }

        divisionBtn.setOnClickListener {
            prilmaryTv.text=(prilmaryTv.text.toString()+"/")
        }
        brace1Btn.setOnClickListener {
            prilmaryTv.text=(prilmaryTv.text.toString()+"(")
        }
        brace2Btn.setOnClickListener {
            prilmaryTv.text=(prilmaryTv.text.toString()+")")
        }
        BtnPie.setOnClickListener {
            prilmaryTv.text=(prilmaryTv.text.toString()+"3.1459")
            secondaryTv.text=(BtnPie.text.toString())
        }
        sinBtn.setOnClickListener {
            prilmaryTv.text=(prilmaryTv.text.toString()+"sin")
        }
        CosBtn.setOnClickListener {
            prilmaryTv.text=(prilmaryTv.text.toString()+"cos")
        }
        tanBtn.setOnClickListener {
            prilmaryTv.text=(prilmaryTv.text.toString()+"tan")
        }
        InvBtn.setOnClickListener {
            prilmaryTv.text=(prilmaryTv.text.toString()+"^"+"(-1)")
        }
        lnBtn.setOnClickListener {
            prilmaryTv.text=(prilmaryTv.text.toString()+"ln")
        }
        logBtn.setOnClickListener {
            prilmaryTv.text=(prilmaryTv.text.toString()+"log")
        }
        SubtactinBtn.setOnClickListener {
            val str: String=prilmaryTv.text.toString()
            if(!str.get(str.length-1).equals("-")){
                prilmaryTv.text=(prilmaryTv.text.toString()+"-")
            }
        }
        MultiplyBtn.setOnClickListener {
            val str: String=prilmaryTv.text.toString()
            if(!str.get(str.length-1).equals("*")){
                prilmaryTv.text=(prilmaryTv.text.toString()+"*")
            }
        }
        squarerootBtn.setOnClickListener {
            if(prilmaryTv.text.toString().isEmpty()){
                Toast.makeText(this,"Please Enter a valid Number", Toast.LENGTH_SHORT).show()
            }
            else
            {
                val str: String=prilmaryTv.text.toString()
                val r= Math.sqrt(str.toDouble())
                val result=r.toString()
                prilmaryTv.text=result
            }
        }
        AcBtn.setOnClickListener {
            prilmaryTv.text=""
            secondaryTv.text=""
        }
        CBtn.setOnClickListener {
            var str: String=prilmaryTv.text.toString()
            if(!str.equals("")){
                str=str.substring(0,str.length-1)
                prilmaryTv.text=str
            }
        }
        squareBtn.setOnClickListener {
            if(prilmaryTv.text.toString().isEmpty()){
                Toast.makeText(this,"Please Enter a valid Number", Toast.LENGTH_SHORT).show()
            }
            else{
                val d: Double=prilmaryTv.text.toString().toDouble()
                val square=d*d
                prilmaryTv.text=square.toString()
                secondaryTv.text=square.toString()
            }
        }
        factBtn.setOnClickListener {
            if(prilmaryTv.text.toString().isEmpty()){
                Toast.makeText(this,"Please Enter a valid Number", Toast.LENGTH_SHORT).show()
            }
            else{
                val value:Int=prilmaryTv.text.toString().toInt()
                val fact:Int=factorial(value)
                prilmaryTv.text=fact.toString()
                secondaryTv.text=fact.toString()
            }
        }
        BtnEqual.setOnClickListener {
            val str: String=prilmaryTv.text.toString()
            val result:Double = evaluate(str) as Double
            val r=result.toString()
            prilmaryTv.text=r
            secondaryTv.text=str
        }


    }
    fun factorial(n:Int):Int{
        return if(n==1 || n==0)1 else n*factorial(n-1)
    }
    fun evaluate(str:String): Any {
       return object : Any()
        {
            var pos=-1
            var ch=0

            fun nextchar(){
                ch=if(++pos <str.length)str[pos].toInt() else-1
            }

            fun eat(charToEdt:Int): Boolean{
                while (ch==' '.toInt())nextchar()
                if(ch==charToEdt){
                    nextchar()
                    return true
                }
                return false
            }
            fun parse(): Double{
                nextchar()
                val x=parseExpression()
                if (pos<str.length) throw RuntimeException("Unexpented :"+ch.toChar())
                return x
            }
            fun parseExpression(): Double{
                var x=parseTerm()
                while (true){
                    if(eat('+'.toInt()))x +=parseTerm()
                    else if(eat('-'.toInt()))x -=parseTerm()
                    else return x
                }
            }
            fun parseTerm(): Double{
                var x=parseFactor()
                while (true)
                    if(eat('*'.toInt()))x *=parseFactor()
                    else if(eat('/'.toInt()))x /=parseFactor()
                    else return x
            }
            fun parseFactor(): Double{
                if(eat('+'.toInt()))return  parseFactor()
                if(eat('-'.toInt()))return  parseFactor()

                var x: Double
                val startPos=pos
                if(eat('C'.toInt())){
                    x=parseExpression()
                    eat(')'.toInt())
                }
                else if(ch>='0'.toInt() && ch<='9'.toInt()||ch=='.'.toInt()){
                    while (ch>='0'.toInt()&&ch<='9'.toInt()||ch=='.'.toInt())nextchar()

                    x=str.substring(startPos,pos).toDouble()
                }
                else if(ch>='a'.toInt()&&ch<='z'.toInt()) {
                    while (ch>='a'.toInt()&&ch<='z'.toInt())nextchar()
                    val func = str.substring(startPos, pos)
                    x = parseFactor()
                     if (func =="sqrt"){
                        x=Math.sqrt(x)
                    }
                    else if (func == "sin")
                    {
                        x=Math.sin(Math.toRadians(x))
                    }
                    else if (func == "cos") {
                        x=Math.cos(Math.toRadians(x))
                    }
                    else if (func == "tan"){
                        x=Math.tan(Math.toRadians(x))
                    }
                    else if(func== "log"){
                        x=Math.log10(x)
                    }
                    else if(func== "ln"){
                        x=Math.log(x)
                    }



                }
                else{
                    throw RuntimeException("Unknowm Excepton :"+ch.toChar())
                }
                if(eat('^'.toInt())) x=Math.pow(x,parseFactor())
                return x


            }


        }.parse()
    }
}