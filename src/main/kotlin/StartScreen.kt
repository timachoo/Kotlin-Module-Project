class StartScreen(nextScreen: (Screens, InfoObject?) -> Unit, exitScreen: () -> Unit) : Screen(nextScreen, exitScreen){
     override fun printContent() {
        MenuNavigation.navigationInput(
            "Выберите действие:",
            mutableListOf(
                "Создать архив",
                "Открыть архив",
                "Выйти"
            )
        ) { num ->
            when (num) {
                1 -> nextScreen(Screens.CREATE_ARCHIVE, null)
                2 -> nextScreen(Screens.OPEN_ARCHIVE, null)
                3 -> {
                    exit()
                }
            }
        }
    }
}