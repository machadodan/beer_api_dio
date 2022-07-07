package one.digitalinnovation.beerstock.service;

import one.digitalinnovation.beerstock.builder.BeerDTOBuilder;
import one.digitalinnovation.beerstock.dto.BeerDTO;
import one.digitalinnovation.beerstock.entity.Beer;
import one.digitalinnovation.beerstock.exception.BeerAlreadyRegisteredException;
import one.digitalinnovation.beerstock.mapper.BeerMapper;
import one.digitalinnovation.beerstock.repository.BeerRepository;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.regex.Matcher;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

// CONTINUAR DA AULA DE TESTE 3


@ExtendWith(MockitoExtension.class)
public class BeerServiceTest {

    public static final long INVALID_BEER_ID = 1L;

    @Mock
    private BeerRepository beerRepository;

    private BeerMapper beerMapper = BeerMapper.INSTANCE;

    @InjectMocks
    private BeerService beerService;

    @Test
    void whenBeerInformedThenItShuldBeCreated() throws BeerAlreadyRegisteredException {
        // given entrada
       BeerDTO expectedBeerDTO = BeerDTOBuilder.builder().build().toBeerDTO();
        Beer expectedSavedBeer = beerMapper.toModel(expectedBeerDTO);

        // when quando
        when(beerRepository.findByName(expectedBeerDTO.getName())).thenReturn(Optional.empty());
        when(beerRepository.save(expectedSavedBeer)).thenReturn(expectedSavedBeer);

        // then teste com Mockito
      /*  BeerDTO createBeerDTO = beerService.createBeer(expectedBeerDTO);

        assertThat(createBeerDTO.getId(), is(equalTo(expectedBeerDTO.getId())));

        assertEquals(expectedBeerDTO.getId(), createBeerDTO.getId());
        assertEquals(expectedBeerDTO.getName(), createBeerDTO.getName());*/

        BeerDTO createdBeerDTO = beerService.createBeer(expectedBeerDTO);

        // test hancrest
        assertThat(createdBeerDTO.getId(), is(equalTo(expectedBeerDTO.getId())));
        assertThat(createdBeerDTO.getName(), is(equalTo(expectedBeerDTO.getName())));
        assertThat(createdBeerDTO.getQuantity(), is(equalTo(expectedBeerDTO.getQuantity())));

        // verifica se a quantidade 2 é maior que 10
        assertThat(createdBeerDTO.getQuantity(), is(greaterThan(2)));

    }

}
