package org.avstream.mvp_simple

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class MainPresenterTest {

    @Mock private lateinit var mainRepository: MainRepository
    @Mock private lateinit var mainContractView: MainContract.View

    private lateinit var mainPresenter: MainPresenter

    @Before
    fun setupPresenter() {
        MockitoAnnotations.openMocks(this)
        mainPresenter = MainPresenter(mainRepository, mainContractView)
    }

    @Test
    fun createPresenter_setsThePresenterToView() {
        mainPresenter = MainPresenter(mainRepository, mainContractView)
        verify(mainContractView).presenter = mainPresenter
    }

    @Test
    fun start() {
        mainPresenter.start()

        verify(mainContractView).showProgress(false)
        verify(mainRepository).getData()
        verify(mainContractView).setData(mainRepository.getData())
        verify(mainContractView).showProgress(true)
    }
}