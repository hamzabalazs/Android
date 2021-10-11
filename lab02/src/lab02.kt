interface IDictionary{
    fun find(word:String, wordlist: MutableList<String>): Boolean
    fun add(word:String, wordlist:MutableList<String>): Boolean
    fun size(wordlist: MutableList<String>): Int
}

class ListDictionary : IDictionary{
    val wordlist = mutableListOf<String>()

    override fun find(word:String, wordlist: MutableList<String>): Boolean{
        for (search in wordlist){
            if (search == word) return true
        }
        return false
    }
    override fun add(word:String, wordlist:MutableList<String>): Boolean{
        if (!find(word,wordlist)){
            wordlist += word
            return true
        }
        return false
    }
    
}

fun main(){
    val dict: IDictionary = ListDictionary
    println("Number of words: ${dict.size()}")
    var word: String?
    while(true){
        print("What to find? ")
        word = readLine()
        if( word.equals("quit")){
            break
        }
        println("Result: ${word?.let { dict.find(it) }}")
    }
}