package bonch.dev.school

class Counter(initialCount:Int=0) {
    var currentCount=initialCount
    private set
    fun increment(){
        currentCount++
    }
}