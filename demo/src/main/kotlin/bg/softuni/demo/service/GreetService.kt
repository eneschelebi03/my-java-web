package bg.softuni.demo.service

import org.springframework.stereotype.Service

@Service
class GreetService {


    fun generateGreeting(name : String) : String {

        return "Hello $name"
    }
}
