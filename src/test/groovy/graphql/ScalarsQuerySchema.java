package graphql;


import graphql.schema.*;

import static graphql.schema.GraphQLArgument.newArgument;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLObjectType.newObject;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ScalarsQuerySchema {

    public static final DataFetcher inputDF = new DataFetcher() {
        @Override
        public Object get(DataFetchingEnvironment environment) {
            return environment.getArgument("input");
        }
    };

    public static final GraphQLObjectType queryType = newObject()
            .name("QueryType")
            /** Static Scalars */
            .field(newFieldDefinition()
                    .name("bigInteger")
                    .type(Scalars.GraphQLBigInteger)
                    .staticValue(BigInteger.valueOf(9999))
                    .build())
            .field(newFieldDefinition()
                    .name("bigDecimal")
                    .type(Scalars.GraphQLBigDecimal)
                    .staticValue(BigDecimal.valueOf(1234.0))
                    .build())
            .field(newFieldDefinition()
                    .name("floatNaN")
                    .type(Scalars.GraphQLFloat)
                    .staticValue(Double.NaN)
                    .build())
            
            
            
            
            /** Scalars with input of same type, value echoed back */
            .field(newFieldDefinition()
                    .name("bigIntegerInput")
                    .type(Scalars.GraphQLBigInteger)
                    .argument(newArgument()
                            .name("input")
                            .type(new GraphQLNonNull(Scalars.GraphQLBigInteger))
                            .build())
                    .dataFetcher(inputDF)
                    .build())
            .field(newFieldDefinition()
                    .name("bigDecimalInput")
                    .type(Scalars.GraphQLBigDecimal)
                    .argument(newArgument()
                            .name("input")
                            .type(new GraphQLNonNull(Scalars.GraphQLBigDecimal))
                            .build())
                    .dataFetcher(inputDF)
                    .build())
            .field(newFieldDefinition()
                    .name("floatNaNInput")
                    .type(Scalars.GraphQLFloat)
                    .argument(newArgument()
                            .name("input")
                            .type(new GraphQLNonNull(Scalars.GraphQLFloat))
                            .build())
                    .dataFetcher(inputDF)
                    .build())
            .field(newFieldDefinition()
                    .name("stringInput")
                    .type(Scalars.GraphQLString)
                    .argument(newArgument()
                            .name("input")
                            .type(new GraphQLNonNull(Scalars.GraphQLString))
                            .build())
                    .dataFetcher(inputDF)
                    .build())
            
            
            
            
            
            
            /** Scalars with input of String, cast to scalar */
            .field(newFieldDefinition()
                    .name("bigIntegerString")
                    .type(Scalars.GraphQLBigInteger)
                    .argument(newArgument()
                            .name("input")
                            .type(Scalars.GraphQLString)
                            .build())
                    .dataFetcher(inputDF)
                    .build())
            .field(newFieldDefinition()
                    .name("bigDecimalString")
                    .type(Scalars.GraphQLBigDecimal)
                    .argument(newArgument()
                            .name("input")
                            .type(Scalars.GraphQLString)
                            .build())
                    .dataFetcher(inputDF)
                    .build())
            .field(newFieldDefinition()
                    .name("floatString")
                    .type(Scalars.GraphQLFloat)
                    .argument(newArgument()
                            .name("input")
                            .type(Scalars.GraphQLString)
                            .build())
                    .dataFetcher(inputDF)
                    .build())
            .field(newFieldDefinition()
                    .name("longString")
                    .type(Scalars.GraphQLLong)
                    .argument(newArgument()
                            .name("input")
                            .type(Scalars.GraphQLString)
                            .build())
                    .dataFetcher(inputDF)
                    .build())
            .field(newFieldDefinition()
                    .name("intString")
                    .type(Scalars.GraphQLInt)
                    .argument(newArgument()
                            .name("input")
                            .type(Scalars.GraphQLString)
                            .build())
                    .dataFetcher(inputDF)
                    .build())
            .field(newFieldDefinition()
                    .name("shortString")
                    .type(Scalars.GraphQLShort)
                    .argument(newArgument()
                            .name("input")
                            .type(Scalars.GraphQLString)
                            .build())
                    .dataFetcher(inputDF)
                    .build())
            .field(newFieldDefinition()
                    .name("byteString")
                    .type(Scalars.GraphQLByte)
                    .argument(newArgument()
                            .name("input")
                            .type(Scalars.GraphQLString)
                            .build())
                    .dataFetcher(inputDF)
                    .build())
            .build();


    public static final GraphQLSchema scalarsQuerySchema = GraphQLSchema.newSchema()
            .query(queryType)
            .build();
}
