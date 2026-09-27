## Why is constructor injection often preferred over field or setter injection?
It ensures immutability (via final fields) and null safety by forcing dependencies to be filled at creation. It also makes unit testing simple without needing reflection or mocking frameworks.

## What problems did you encounter writing your own container that Weld solved automatically?
Weld automatically handles circular dependencies using lazy proxies, manages thread-safe concurrent access, and cleans up out-of-scope objects to prevent massive memory leaks.

## How does adding scopes (@ApplicationScoped, etc.) change object lifetimes?
Scopes detach an object's life from its caller. @ApplicationScoped keeps one instance alive for the entire app deployment, while @RequestScoped creates a fresh instance for a single HTTP request and destroys it immediately afterwards.
