class MenuNavigation {
    val screens = mutableListOf<Screen>()

    fun exit() {
        screens.removeLast()
        screens.lastOrNull()?.printContent()
    }

    fun nextScreen(screen: Screens, params: InfoObject? = null) {
        val screenObject = when (screen) {
            Screens.ARCHIVE -> StartScreen(::nextScreen, ::exit)
            Screens.CREATE_ARCHIVE -> CreateArchiveScreen(::nextScreen,::exit)
            Screens.OPEN_ARCHIVE -> OpenArchiveScreen(::nextScreen, ::exit)
            Screens.CREATE_NOTE -> {
                val param = (params as Archive)
                CreareNote(::nextScreen, ::exit, param)
            }
            Screens.OPEN_NOTE -> {
                val param = (params as Archive)
                OpenNote(::nextScreen, ::exit, param)
            }
            Screens.VIEW_NOTE -> {
                val param = (params as Note)
                ViewNote(::nextScreen, ::exit, param)
            }
        }
        screens.add(screenObject)
        screenObject.printContent()
    }

    companion object {
        val archives : MutableList<Archive> = mutableListOf()

        fun navigationInput(title: String, navigation: List<String>, function: (Int) -> Unit) {
            println(title)
            navigation.forEachIndexed { index, s ->
                println("${index + 1} - $s")
            }
            val inputText = readLine()
            val answer = inputText?.trim()?.toIntOrNull()
            if (answer != null && answer <= navigation.count()) {
                function(answer)
            } else {
                if (answer == null) {
                    println("Ошибка, введите цифру")
                } else {
                    println("Ошибка, такого номера нет, выберете из предложенного")
                }
                navigationInput(title, navigation, function)
            }
        }
    }
}