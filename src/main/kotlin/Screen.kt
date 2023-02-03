abstract class Screen(val nextScreen: (Screens, InfoObject?) -> Unit, val exitScreen: () -> Unit) {
    abstract fun printContent()
    open fun exit(){
        exitScreen()
    }

}