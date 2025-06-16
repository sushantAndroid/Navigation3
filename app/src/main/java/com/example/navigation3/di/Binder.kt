import com.example.navigation3.domain.navigation.NavManager
import com.example.navigation3.domain.navigation.NavManagerImpl
import com.example.navigation3.persentation.viewmodel.UserRepository
import com.example.navigation3.persentation.viewmodel.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NavigationModule {

    @Binds
    @Singleton
    abstract fun bindNavManager(navManagerImpl: NavManagerImpl): NavManager
}


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindUserRepository(
        userRepositoryImpl: UserRepositoryImpl, // Fixed: bind to the implementation class
    ): UserRepository
}